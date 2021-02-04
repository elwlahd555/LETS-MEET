<template>
  <v-container>
    <Chat 
      :initial-feed="feed"
      :title="'My Best Team'"
      :initial-author-id="authorId"
      @newOwnMessage="onNewOwnMessage"
    />
  </v-container>
</template>

<script>
import Chat from 'basic-vue-chat'
import moment from 'moment'
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'


export default {
  name: "Chatting",
  components: {
    Chat,
  },
  data() {
    return {
      authorId: 1,
      authname: '',
      toggleEmojiPicker: false,
      message: {
        id: 0,
        author: 'Person',
        imageUrl: 'http://path/to/image',
        image: '',
        contents: '테스트 중',
        date: '16:30'
      },
      user: {
        1: "이성헌",
        2: "Admin",
        3: "People"
      }
      ,
      feed: [
      ],
    }
  },
  created() {
    this.connect()
    this.authname = this.$store.state.name
    console.log(this.$store.state)
    if (this.authname === '이성헌') {
      this.authorId = 1
    } else if (this.authname === 'admin') {
      this.authorId = 2
    } else {
      this.authorId = 3
    }
    console.log(this.authname + this.authorId)
  },
  methods: {
    onNewOwnMessage (message, image, imageUrl) {
      const newOwnMessage = {
        id: this.authorId,
        author: this.authname,
        contents: message,
        image: image,
        imageUrl: imageUrl,
        date: moment().format('HH:mm:ss')
      }
      console.log(newOwnMessage)
      this.message = newOwnMessage
      this.feed.pop()
      this.send()
    },
    onOpenEmojiPicker (toggle) {
      this.setEmojiPickerToggle(toggle)
    },
    created() {
      this.connect()
    },  
    send() {
      if (this.stompClient && this.stompClient.connected) {
        const msg = { 
          mrcUNo: this.authorId,
          mrcContent: this.message.contents 
        };
        console.log(msg)
        this.stompClient.send("/receive", JSON.stringify(msg), {});
      }
    },    
    connect() {
      const serverURL = "http://localhost:8000/letsmeet/websocket"
      let socket = new SockJS(serverURL);
      this.stompClient = Stomp.over(socket);
      console.log(`소켓 연결을 시도합니다. 서버 주소: ${serverURL}`)
      this.stompClient.connect(
        {},
        frame => {
          // 소켓 연결 성공
          this.connected = true;
          console.log('소켓 연결 성공', frame);
          // 서버의 메시지 전송 endpoint를 구독합니다.
          // 이런형태를 pub sub 구조라고 합니다.
          this.stompClient.subscribe("/send", res => {
            console.log('구독으로 받은 메시지 입니다.', this.authname, JSON.parse(res.body));
            this.message = {
              id: JSON.parse(res.body).mrcUNo,
              author: this.user[JSON.parse(res.body).mrcUNo],
              contents: JSON.parse(res.body).mrcContent,
              image: '',
              imageUrl: '',
              date: moment().format('HH:mm:ss')
            }
            console.log(this.message)
            // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
            this.feed.push(this.message)
            // this.recvList.push(JSON.parse(res.body))
          });
        },
        error => {
          // 소켓 연결 실패
          console.log('소켓 연결 실패', error);
          this.connected = false;
        }
      );        
    },
  },
}
</script>
<style lang="scss">
  .window {
      max-width: 500px !important;
      height: 450px !important;
  }
  .window__header__container {
    background: #536DFE !important;
  }
  .window .message--own .message__contents {
    color: black !important;
    background-color: #C5CAE9 !important;
  }
  .window .message--foreign .message__contents {
    background-color: #80DEEA !important;
  }
  .window__input__container .input__button {
    background-color: #536DFE !important;
    color: #FAF9FF;
  }
  .window__input__container .input__field {
    background-color: #FAF9FF !important;
  }
</style>