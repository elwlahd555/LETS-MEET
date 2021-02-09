<template>
  <v-container>
    <hooper :settings="hooperSettings" style="height:100%;">
      <slide v-for="(place, i) in recPlace" :key="i">
        <RecommendItem :place="place" />
      </slide>
    </hooper>
  </v-container>
</template>

<script>
import { Hooper, Slide } from 'hooper';
import 'hooper/dist/hooper.css';
import RecommendItem from './RecommendItem.vue'


export default {
  name: "MiddlePointRecommend",
  components: {
    Hooper,
    Slide,
    RecommendItem,
  },
  props: {
    recPlace: Array,
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
    }
  }
}
</script>

<style>

</style>