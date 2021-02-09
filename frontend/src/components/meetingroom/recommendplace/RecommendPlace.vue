<template>
  <v-container>
    <div class="d-flex justify-start ml-3">
      <v-icon color="indigo accent-2">mdi-record-circle-outline</v-icon><v-subheader class="pl-2">중간 지점 장소 추천</v-subheader>
    </div>
    <v-list-item-subtitle class="d-flex justify-start ml-4">만남 멤버들의 중간 지점 주변의 핫플을 추천</v-list-item-subtitle>
    <MiddlePointRecommend :recPlace="recPlace" />

    <div class="d-flex justify-start ml-3">
      <v-icon color="indigo accent-2">mdi-help-circle</v-icon><v-subheader class="pl-2">랜덤 장소 추천</v-subheader>
    </div>
    <v-list-item-subtitle class="d-flex justify-start ml-4">만남 멤버 중 한 멤버 주변의 장소를 랜덤 추천</v-list-item-subtitle>
    <MiddlePointRecommend :recPlace="recPlace" />
  </v-container>
</template>

<script>
import MiddlePointRecommend from './middlepointrecommend/MiddlePointRecommend.vue'
export default {
  name: "RecommendPlace",
  components: {
    MiddlePointRecommend,
  },
  props: {
    recPlace: Array,
  },
  mounted() {
    console.log(this.recPlace)
  }
}
</script>

<style>

</style>