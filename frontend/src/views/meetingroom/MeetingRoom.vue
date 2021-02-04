<template>
  <v-container>
    <v-card
      class="mx-auto mb-5"
      max-width="100%"
    >
      <v-img
        :src="type[roomInfo.mrCategory][1]"
        height="200px"
      ></v-img>
      <v-card-actions>
        <v-btn
          text
        >
          <h5>{{ roomInfo.mrName }}</h5>
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn
          icon
          @click="show = !show"
        >
          <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <v-container v-show="show">
          <v-divider></v-divider>
          약속 유형 : {{ roomInfo.mrCategory }} <br>
          멤버 : 홍길동 외 4명 <br>
          시간 : {{ roomInfo.mrDateStart }} ~ {{ roomInfo.mrDateEnd }} <br>
          장소 : 미정 <br>
        </v-container>
      </v-expand-transition>
    </v-card>



    <v-sheet elevation="6">
    <v-tabs
      background-color="indigo accent-2"
      dark
      centered
      next-icon="mdi-arrow-right-bold-box-outline"
      prev-icon="mdi-arrow-left-bold-box-outline"
      show-arrows
      v-model="tab"
    >
      <v-tab>
        약속 선택
      </v-tab>
      <v-tab>
        장소 추천
      </v-tab>
      <v-tab>
        채팅
      </v-tab>
      <v-tab>
        멤버
      </v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item>
        <DeterminePromise />
      </v-tab-item>
      <v-tab-item>
        22
      </v-tab-item>
      <v-tab-item>
        <Chatting />
      </v-tab-item>
      <v-tab-item>
        <Member />
      </v-tab-item>
    </v-tabs-items>
  </v-sheet>
  </v-container>
</template>

<script>
import Member from "../../components/meetingroom/member/Member.vue";
import DeterminePromise from "../../components/meetingroom/determinepromise/DeterminePromise.vue";
import Chatting from "../../components/meetingroom/chatting/Chatting.vue";
const axios = require('axios');

export default {
  name: "MeetingRoom",
  components: {
    Member,
    DeterminePromise,
    Chatting,
  },
  data () {
    return {
      show: false,
      tab: 'tab-1',
      mrNo: 0,
      roomInfo: [],
      type: {
        '밥': ['mdi-food', 'https://www.gyeongju.go.kr/upload/content/thumb/20200529/A42F50C69A8A4DDB94DA408C290735C1.jpg'],
        '카페': [ 'mdi-coffee', 'http://www.lightingnews.net/images/theme/cafe_01.png'],
        '술': ['mdi-glass-mug-variant', 'https://img.lovepik.com/photo/50011/5863.jpg_wh860.jpg'],
        '스터디': ['mdi-book-open-page-variant', 'https://modo-phinf.pstatic.net/20180304_283/1520151276251GkP1Q_JPEG/mosaOtd1XG.jpeg?type=w720'],
        '놀거리': ['mdi-snowboard', 'https://www.travel.taipei/image/65598/1024x768'],
        '기타': ['mdi-dots-horizontal', 'http://img.rflogix.com/agm/main/1024/10_1_20200407112854.jpg'],
      },
    }
  },
  mounted() {
    this.mrNo = this.$route.params.id
    this.getRoomInfo()
  },
  methods: {
    getRoomInfo() {
      axios.get(`http://localhost:8000/letsmeet/meetingRoom/detail?mrNo=${this.mrNo}`)
      .then((res)=> {
        this.roomInfo = res.data
        console.log(this.roomInfo)
      })
      .catch((err) => {
        console.log(err)
      })
    },
  }
}
</script>
<style scoped>
</style>