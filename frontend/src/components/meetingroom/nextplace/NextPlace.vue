<template>
  <v-container>
    <div class="d-flex justify-start ml-3">
      <v-icon color="indigo accent-2">mdi-google-analytics</v-icon><v-subheader class="pl-2">채팅 분석</v-subheader>
    </div>
    <v-list-item-subtitle class="d-flex justify-start ml-4">대화내용 분석 결과</v-list-item-subtitle>
    <ResultNLP :roomInfo='roomInfo' @nlp_words='nlpWords' />

    <div class="d-flex justify-start ml-3">
      <v-icon color="indigo accent-2">mdi-map-search</v-icon><v-subheader class="pl-2">다음 장소 추천</v-subheader>
    </div>
    <v-list-item-subtitle class="d-flex justify-start ml-4">채팅의 대화내용 분석 결과를 토대로 장소 추천</v-list-item-subtitle>
    <NextPlaceNLP :roomInfo='roomInfo' :nlpWordsList='nlpWordsList' />

    <div class="d-flex justify-start ml-3">
      <v-icon color="indigo accent-2">mdi-help-circle</v-icon><v-subheader class="pl-2">랜덤 장소 추천</v-subheader>
    </div>
    <v-list-item-subtitle class="d-flex justify-start ml-4">다음 약속 장소를 랜덤 추천</v-list-item-subtitle>
    <RandomPointRecommend :ranPlace="ranPlace" :roomInfo="roomInfo"/>
    
  </v-container>
</template>

<script>
import RandomPointRecommend from '@/components/meetingroom/recommendplace/pointrecommend/RandomPointRecommend.vue'
import ResultNLP from '../../../components/meetingroom/nextplace/nlpresult/ResultNLP'
import NextPlaceNLP from '../../../components/meetingroom/nextplace/nlpresult/NextPlaceNLP'

const axios = require('axios');
const server_URL = process.env.VUE_APP_SERVER_URL

export default {
  name: "NextPlace",
  data() {
    return {
      ranPlace: [],
      nlpWordsList: [],
    }
  },
  components: {
    RandomPointRecommend,
    ResultNLP,
    NextPlaceNLP
  },
   props: {
    mrUserInfo: Array,
    roomInfo: Object,
  },
  mounted() {
    this.getRandomPlace()
  },
  methods: {
    nlpWords(data) {
      this.nlpWordsList = data
    },
    getRandomPlace() {
      let randoms = [];
      let i = 0;
      while (i < 6) {
        let n = Math.floor(Math.random() * 1500) + 1;
        if (! sameNum(n)) {
          randoms.push(n);
          i++;
        }
      }
      function sameNum (n) {
        return randoms.find((e) => (e === n));
      }
      for (var idx of randoms) {
        axios.get(`${server_URL}/letsmeet/map/sno?sno=${idx}`)
        .then((res)=> {
          this.ranPlace.push(res.data)
        })
        .catch((err) => {
          console.log(err)
        })
      }
    }
  }
}
</script>

<style>

</style>