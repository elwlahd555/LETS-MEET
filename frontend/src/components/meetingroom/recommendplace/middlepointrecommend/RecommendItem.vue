<template>
  <div>
    <v-card style="height: 100%;" class="mr-1">
      <v-img
      class= 'd-flex align-end'
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
      height="150"
      >
      </v-img>
      <v-card-title style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
          {{place.sName}}
      </v-card-title>
      <v-card-text>
          {{place.sRoad}}
      </v-card-text>
      <v-card-actions class="d-flex justify-space-between m-0 pr-0">
        <v-btn
          color="indigo accent-2"
          text
        >
          DETAIL
        </v-btn>
        <v-btn text>
          <v-icon color="red">mdi-heart</v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "RecommendItem",
  props: {
    place: Object
  }
}
</script>

<style>

</style>