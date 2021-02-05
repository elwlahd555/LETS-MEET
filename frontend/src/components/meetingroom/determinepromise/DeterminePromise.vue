<template>
  <v-container>
    <v-subheader>내 약속 일정 선택</v-subheader>
    <v-container>
      <MyPromise :roomInfo="roomInfo" @refresh="refresh"/>
    </v-container>
    <hr>
    <v-subheader>약속 가능 날짜</v-subheader>
    <v-date-picker
      v-model="date2"
      :event-color="date => date[9] % 2 ? 'red' : 'yellow'"
      :events="functionEvents"
      full-width
      no-title
      color="#536DFE"
      readonly
      min="2021-02-01"
      max="2021-02-05"
    ></v-date-picker>
    <hr>
    <v-subheader>출발 장소</v-subheader>
    <v-container>
      홍길동 : 인동초등학교 <br>
      임꺽정 : 삼성전자 <br>
      춘향 : IWC <br>
    </v-container>
  </v-container>
</template>



<script>
import MyPromise from "./MyPromise.vue";
const axios = require('axios');

export default {
  name: "DeterminePromise",
  components: {
    MyPromise,
  },
  props: {
    roomInfo: Array,
    mrUserInfo: Array
  },
  data: () => ({
    arrayEvents: null,
    // date2: new Date().toISOString().substr(0, 10),
    date2: []
  }),
  mounted () {
    this.arrayEvents = [...Array(6)].map(() => {
      const day = Math.floor(Math.random() * 30)
      const d = new Date()
      d.setDate(day)
      return d.toISOString().substr(0, 10)
    })
    this.departure()
  },

  methods: {
    functionEvents (date) {
      const [,, day] = date.split('-')
      if ([1, 2, 3].includes(parseInt(day, 10))) return true
      if ([1, 2, 4, 5].includes(parseInt(day, 10))) return ['green accent-3']
      return false
    },
    departure() {
      axios.get(`https://dapi.kakao.com/v2/local/geo/coord2address.json?x=127.423084873712&y=37.0789561558879&input_coord=WGS84`, {
        headers: {
          Authorization: `KakaoAK 005fbdb435b40b9acf0eabc1b2010e7b`
        }
      })
      .then((res)=> {
        console.log(res.data.documents[0].address.address_name)
      })
      .catch((err) => {
        console.log(err)
      })
    },
    refresh() {

    }
  },
}
</script>

<style>

</style>