<template>
  <div>
    <UpdateRoom :id='id' v-show="isMake" @is_next="isNext" @update_room_title="updateRoomTitle" @update_idx="updateIdx" @upload_img="uploadImg"/>
    <!-- <UpdateRoom v-show="isMake" @is_next="isNext" @update_room_title="updateRoomTitle" @update_idx="updateIdx" @upload_img="uploadImg"/> -->
    <UpdateSchedule :id='id' v-show="isMake2" @is_prev="isPrev" @update_dates="updateDates" @update_room="updateRoom"/>
  </div>
</template>
<script>
import UpdateRoom from "../../components/updatemeeting/UpdateRoom.vue";
import UpdateSchedule from "../../components/updatemeeting/UpdateSchedule.vue";

const axios = require('axios');

export default {
  name: "UpdateMeetingRoom",
  components: {
    UpdateRoom,
    UpdateSchedule
  },
  props: {
      id: {
        type: String,
      }
  },
  data: function() {
    return {
      isMake: true,
      isMake2: false,
      update_room_title: '',
      update_room_type: '',
      update_dates: [],
      iFile: '',
      mrNo: this.id,
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
      this.update_room_title = data
    },
    updateIdx(data) {
      this.update_room_type = data
    },
    updateDates(data) {
      this.update_dates = data
    },
    uploadImg(data) {
      this.iFile = data
    },
    updateRoom() {
      if (this.update_room_title && this.update_room_type && this.update_dates.length > 0){
        var tmp_end_day = ''
        if (this.update_dates.length == 2) {
          tmp_end_day = this.update_dates[1]
        } else {
          tmp_end_day = this.update_dates[0]
        }
        const data = {
          mrNo : this.mrNo,
          mrImage: this.iFile,
          mrName: this.update_room_title,
          mrCategory: this.update_room_type,
          mrDateStart: this.update_dates[0],
          mrDateEnd: tmp_end_day,
          mrSuperUNo: this.$store.state.uNo
        }
        console.log(data)
        axios.put(`http://localhost:8000/letsmeet/meetingRoom/edit`, data )
          .then(()=> {
            alert('방 정보가 수정되었습니다.')
            this.$router.push({ name: 'Main'});
          })
          .catch(() => {
            alert('방 정보 수정에 실패하셨습니다.')
          })
        
        // 임시방편
        axios.get(`http://localhost:8000/letsmeet/main?uNo=${this.$store.state.uNo}`)
          .then((res)=> {
            const data = res.data
            this.$store.state.mrNo = data[data.length-1].mrNo
            console.log(this.$store.state.mrNo)
          })
          .catch((err) => {
            console.log(err)
          })
          setTimeout(() => { this.$fileSelect() }, 500)
      }else {
        alert("데이터를 모두 입력해주세요.")
      }
    },
    // 파일 첨부시 Change이벤트
    $fileSelect : function $fileSelect() {
        this.$executeSave();
    },
    // 저장
    $executeSave : function $executeSave() {
      //const url = 'letsmeet/image/meetingroomImageUpload'; // 서버에 올릴땐 이거 써야한다.
  
      //Object To FormData 변환
      var formData = new FormData();
      if(this.iFile != "") {
        formData.append("iFile", this.iFile); // 이미지 파일
        formData.append("mrNo", this.$store.state.mrNo) // 미팅룸 번호
      }
      // * FormData객체는 그 자체를 로깅하면 빈 객체만을 리턴한다.
      // * FormData를 로깅하려면 FormData.entries()를 이용하여 key : value 쌍을 뽑아야 한다.
      for (let key of formData.entries()) {
        console.log(`${key}`);
      }
  
      // 파일 업로드시 경로, FormData, Header 설정
      // axios.post(url, formData, { // 서버에 올릴땐 이거 써야한다.
          axios.post('http://localhost:8000/letsmeet/image/meetingroomImageUpload', formData, { // 이건 로컬용이다.
          header: {
            'Content-Type': 'multipart/form-data'
          }
      }).then(
          response => {
            if(!!response && response.status === 200) {
              console.log('업로드 완료');
            }
          }
      ).catch(error => {
          console.log(error);
      });
    },
  },

}
</script>

<style>

</style>