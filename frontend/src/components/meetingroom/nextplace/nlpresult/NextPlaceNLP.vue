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
    ranPlace: Array,
    roomInfo: Object,
  },
  mounted() {
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
      isDetail: false
    }
  },
  methods: {
    getStoreDetail() {
      // store 전체 데이터를 불러내서 s_category_detail 마다 단어 5개 for 문 때리기 
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