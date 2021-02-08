<template>
  <div>
      <input v-on:change="$fileSelect()" type="file" ref="imgFile" />
  </div>
</template>

<script>
export default {
  name: "Upload",
  data(){
      return {
          imgFile: '',
          imgName: '',
          imgUserName: '',
      }
  },

// 파일 첨부시 Change이벤트
$fileSelect : function $fileSelect() {
    console.log(this.$refs);
    this.imgFile = this.$refs.imgFile.files[0];
},

// 저장
$executeSave : function $executeSave() {
    const url = '/image/upload';

    //Object To FormData 변환
    var formData = new FormData();
    if(this.imgFile != "") {
        formData.append("imgFile", this.imgFile); // 이미지 파일
        formData.append("imgUserName", this.$store.state.uNo)
    }

    // * FormData객체는 그 자체를 로깅하면 빈 객체만을 리턴한다.
    // * FormData를 로깅하려면 FormData.entries()를 이용하여 key : value 쌍을 뽑아야 한다.
    for (let key of formData.entries()) {
        console.log(`${key}`);
    }

    // 파일 업로드시 경로, FormData, Header 설정
    this.$axios.post(url, formData, {
        header: {
            'Content-Type': 'multipart/form-data'
        }
    }).then(
        response => {
            if(!!response && response.status === 200) {
                commonUtils.$alert('업로드 완료');
            }
        }
    ).catch(error => {
        console.log(error);
        commonUtils.$alertUncatchedError(error);
    });
},
}
</script>

<style>

</style>