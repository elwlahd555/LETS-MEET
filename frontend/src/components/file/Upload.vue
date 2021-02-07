<template>
  <div>
      <input v-on:change="$fileSelect()" type="file" ref="imgFile" />
  </div>
</template>

<script>
export default {
  name: "Upload",

// 파일 첨부시 Change이벤트
$fileSelect : function $fileSelect() {
    this.scndhandReg.imgFile = this.$refs.imgFile.files[0];
},

// 저장
$executeSave : function $executeSave() {
    const url = constant.boardFoHost + '/image/upload';

    //Object To FormData 변환
    var formData = new FormData();
    if(this.scndhandReg.imgFile != "") {
        formData.append("imgFile", this.scndhandReg.imgFile); // 이미지 파일
    }

    // 파일 업로드시 경로, FormData, Header 설정
    this.$axios.post(url, formData, { header: {'Content-Type': 'multipart/form-data'}}).then(
        response => {
            if(!!response && response.status === 200) {
                commonUtils.$alert('업로드 완료');
                this.scndhandReg = Object.assign({}, this.defScndhangReg);
            }
        }
    ).catch(error => {
        console.log(error);
        commonUtils.$alertUncatchedError(error);
    })
},
}
</script>

<style>

</style>