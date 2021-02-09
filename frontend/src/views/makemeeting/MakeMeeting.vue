<template>
  <div>
    <MakeRoom v-show="isMake" @is_next="isNext" @update_room_title="updateRoomTitle" @update_idx="updateIdx" @upload_img="uploadImg"/>
    <MakeSchedule v-show="isMake2" @is_prev="isPrev" @update_dates="updateDates" @confirm_room="confirmRoom"/>
  </div>
</template>

<script>
import MakeRoom from "../../components/makemeeting/MakeRoom.vue";
import MakeSchedule from "../../components/makemeeting/MakeSchedule.vue";
const axios = require('axios');

export default {
  name: "MakeMeeting",
  components: {
    MakeRoom,
    MakeSchedule
  },
  data: function() {
    return {
      isMake: true,
      isMake2: false,
      room_title: '',
      room_type: '',
      dates: [],
      iFile: '',
      mrNo: '',
    }
  },
  methods: {
    isNext() {
      this.isMake = false,
      this.isMake2 = true
    },
    isPrev() {
      this.isMake = true,
      this.isMake2 = false
    },
    updateRoomTitle(data) {
      this.room_title = data
    },
    updateIdx(data) {
      this.room_type = data
    },
    updateDates(data) {
      this.dates = data
    },
    uploadImg(data) {
      this.iFile = data
    },
    confirmRoom() {
      if (this.room_title && this.room_type && this.dates.length > 0){
        var tmp_end_day = ''
        if (this.dates.length == 2) {
          tmp_end_day = this.dates[1]
        } else {
          tmp_end_day = this.dates[0]
        }
        const data = {
          mrName: this.room_title,
          mrCategory: this.room_type,
          mrDateStart: this.dates[0],
          mrDateEnd: tmp_end_day,
          mrSuperUNo: this.$store.state.uNo
        }
        console.log(data)
        axios.post(`http://localhost:8000/letsmeet/meetingRoom/create`, data )
          .then(()=> {
            alert('방 생성이 완료되었습니다.')
            this.$router.push({ name: 'Main'});
          })
          .catch(() => {
            alert('방 생성에 실패하셨습니다.')
          })
        
        // 임시방편
        axios.get(`http://localhost:8000/letsmeet/main?uNo=${this.$store.state.uNo}`)
          .then((res)=> {
            const data = res.data
            this.$store.state.mrNo = data[data.length-1].mrNo
            console.log(this.$store.state.mrNo)
          })
          .catch((err) => {
            console.log(err)
          })
          setTimeout(() => { this.$fileSelect() }, 500)
      }else {
        alert("데이터를 모두 입력해주세요.")
      }
    },
    // 파일 첨부시 Change이벤트
    $fileSelect : function $fileSelect() {
        this.$executeSave();
    },
    // 저장
    $executeSave : function $executeSave() {
      //const url = 'letsmeet/image/meetingroomImageUpload'; // 서버에 올릴땐 이거 써야한다.
  
      //Object To FormData 변환
      var formData = new FormData();
      if(this.iFile != "") {
        formData.append("iFile", this.iFile); // 이미지 파일
        formData.append("mrNo", this.$store.state.mrNo) // 미팅룸 번호
      }
      // * FormData객체는 그 자체를 로깅하면 빈 객체만을 리턴한다.
      // * FormData를 로깅하려면 FormData.entries()를 이용하여 key : value 쌍을 뽑아야 한다.
      for (let key of formData.entries()) {
        console.log(`${key}`);
      }
  
      // 파일 업로드시 경로, FormData, Header 설정
      // axios.post(url, formData, { // 서버에 올릴땐 이거 써야한다.
          axios.post('http://localhost:8000/letsmeet/image/meetingroomImageUpload', formData, { // 이건 로컬용이다.
          header: {
            'Content-Type': 'multipart/form-data'
          }
      }).then(
          response => {
            if(!!response && response.status === 200) {
              console.log('업로드 완료');
            }
          }
      ).catch(error => {
          console.log(error);
      });
    },
  },

}
</script>

<style>

</style>