<template>
  <div>
    <v-card
      class="mx-auto mt-3"
      v-for="idx in list"
      :key="idx"
    >
      <v-img 
      height="200px"
      src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      style="filter: brightness(50%);">
      </v-img>
     <v-fade-transition>
        <v-overlay
          absolute >
          <div class="d-flex flex-column mt-5">
            <div class="d-flex justify-center"><v-icon class="mb-1">mdi-food</v-icon> 밥 약속</div>
            <div class="d-flex justify-center"><h4>이모저모 런닝 모임</h4></div>
            <div class="d-flex justify-center">2021.01.14</div>
            <div class="d-flex justify-center">5명</div>
          </div>
        </v-overlay>
      </v-fade-transition>
    </v-card>
    <infinite-loading @infinite="infiniteHandler"></infinite-loading>
  </div>
</template>

<script>
import InfiniteLoading from 'vue-infinite-loading'

export default {
  name: "Main",
  data() {
    return {
      list: [1, 2, 3]
    };
  },
  components: {
    InfiniteLoading,
  },
   methods: {
    infiniteHandler($state) {
      setTimeout(() => {
        const temp = [];
        for (let i = this.list.length + 1; i <= this.list.length + 3; i++) {
          temp.push(i);
        }
        this.list = this.list.concat(temp);
        $state.loaded();
      }, 1000);
    },
  },
}
</script>

<style>

</style>