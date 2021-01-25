<template>
  <div>
    <MakeRoom v-show="isMake" @is_next="isNext"/>
    <MakeSchedule v-show="isMake2" @is_prev="isPrev" />
  </div>
</template>

<script>
import MakeRoom from "../../components/makemeeting/MakeRoom.vue";
import MakeSchedule from "../../components/makemeeting/MakeSchedule.vue";


export default {
  name: "MakeMeeting",
  components: {
    MakeRoom,
    MakeSchedule
  },
  data: function() {
    return {
      isMake: true,
      isMake2: false,
    }
  },
  methods: {
    isNext() {
      this.isMake = false,
      this.isMake2 = true
    },
    isPrev() {
      this.isMake = true,
      this.isMake2 = false
    }
  },

}
</script>

<style>

</style>