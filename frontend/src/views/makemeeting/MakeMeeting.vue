<template>
  <div>
    <MakeRoom v-show="isMake" @is_next="isNext" @update_room_title="updateRoomTitle" @update_idx="updateIdx"/>
    <MakeSchedule v-show="isMake2" @is_prev="isPrev" @update_dates="updateDates" @confirm_room="confirmRoom"/>
  </div>
</template>

<script>
import MakeRoom from "../../components/makemeeting/MakeRoom.vue";
import MakeSchedule from "../../components/makemeeting/MakeSchedule.vue";
const axios = require('axios');

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
      room_title: '',
      room_type: '',
      dates: [],
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
    },
    updateRoomTitle(data) {
      this.room_title = data
    },
    updateIdx(data) {
      this.room_type = data
    },
    updateDates(data) {
      this.dates = data
    },
    confirmRoom() {
      if (this.room_title && this.room_type && this.dates.length > 0){
        var tmp_end_day = ''
        if (this.dates.length == 2) {
          tmp_end_day = this.dates[1]
        } else {
          tmp_end_day = this.dates[0]
        }
        const data = {
          mrName: this.room_title,
          mrCategory: this.room_type,
          mrDateStart: this.dates[0],
          mrDateEnd: tmp_end_day,
          mrSuperUNo: this.$store.state.uNo
        }
        console.log(data)
        axios.post(`http://i4d107.p.ssafy.io:8000/letsmeet/meetingRoom/create`, data )
          .then(()=> {
            alert('방 생성이 완료되었습니다.')
            this.$router.push({ name: 'Main'});
          })
          .catch(() => {
            alert('방 생성에 실패하셨습니다.')
          })
      }else {
        alert("데이터를 모두 입력해주세요.")
      }
    }
  },

}
</script>

<style>

</style>