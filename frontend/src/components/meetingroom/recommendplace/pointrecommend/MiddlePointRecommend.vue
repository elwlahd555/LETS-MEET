<template>
  <v-container>
    <hooper :settings="hooperSettings" style="height:100%;">
      <slide v-for="(place, i) in recPlace" :key="i">
        <RecommendItem :place="place" :roomInfo="roomInfo" @go_detail="goDetail" @refresh="refresh"/>
      </slide>
    </hooper>
    <div v-if="isDetail && place">
      <MiddlePlaceDetail :place="place" class="mt-3"/>
    </div>
  </v-container>
</template>

<script>
import { Hooper, Slide } from 'hooper';
import 'hooper/dist/hooper.css';
import RecommendItem from './RecommendItem.vue'
import MiddlePlaceDetail from './MiddlePlaceDetail.vue'


export default {
  name: "MiddlePointRecommend",
  components: {
    Hooper,
    Slide,
    RecommendItem,
    MiddlePlaceDetail,
  },
  props: {
    recPlace: Array,
    roomInfo: Object,
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