<template>
  <v-container>
    <hooper :settings="hooperSettings" style="height:100%;">
      <slide v-for="(place, i) in ranPlace" :key="i">

        <!-- <RecommendItem :place="place" :roomInfo="roomInfo" @go_detail="goDetail" @refresh="refresh"/> -->
      </slide>
    </hooper>
    <div v-if="isDetail && place">
      <!-- <RandomPlaceDetail :place="place" class="mt-3"/> -->
    </div>
  </v-container>
</template>

<script>
import { Hooper, Slide } from 'hooper';
import 'hooper/dist/hooper.css';
// import RecommendItem from '@/components/meetingroom/recommendplace/pointrecommend/RecommendItem.vue'
// import RandomPlaceDetail from '@/components/meetingroom/recommendplace/pointrecommend/RandomPlaceDetail.vue'


export default {
  name: "NextPlaceNLP",
  components: {
    Hooper,
    Slide,
    // RecommendItem,
    // RandomPlaceDetail,
  },
  props: {
    roomInfo: Object,
    nlpWordsList: Array,
  },
  created() {
    this.getStoreDetail()
  },
  data() {
    return {
      hooperSettings: {
        itemsToShow: 1.5,
        itemsToSlide: 1,
        infiniteScroll: "true",
        detail: "true",
        wheelControl: false,
      },
      place: null,
      isDetail: false,
      nlpPlaceInfo: [],
    }
  },
  methods: {
    getStoreDetail() {  
      // 데이터 받아온걸 토대로 nlpPlaceInfo 에 넣어서 item, detail 각각 넣어주기
      // nlpPlaceInfo 에 다 넣어줌
      
    },
    goDetail(data) {
      this.place = data
      this.isDetail = !this.isDetail
    },
    refresh() {
      this.$emit('refresh')
    },
  }
}
</script>

<style>

</style>