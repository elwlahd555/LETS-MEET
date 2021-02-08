<template>
  <v-container id="onoff">
    <div id="map2"></div>
  </v-container>
</template>

<script>
const KAKAO_API_KEY = '71f77d07e68b0f6c0464d85d3df14e6c'
var map = ''
// const axios = require('axios');
var latitude = 0
var longitude = 0


export default {
  name: "MiddlePoint",
  props: {
    mrUserInfo: Array,
  },
  data () {
    return {
      dialog: false,
      positions: [],
      count: 0
    }
  },
  watch: {
    mrUserInfo() {
      setTimeout(() => { this.initMap() }, 1000)
    }
  },
  created() {
    this.addKakaoMapScript()
  },
  mounted() {
    setTimeout(() => { this.initMap() }, 1000)
  },
  methods: {
    addKakaoMapScript() {
      const script = document.createElement("script")
      script.onload = () => kakao.maps.load()
      script.src =
        `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${KAKAO_API_KEY}`
      document.head.appendChild(script)
    },
    initMap() {
      var con = document.getElementById("onoff")
      var delete_item = document.getElementById("map2");
      con.removeChild(delete_item)
      var newDiv = document.createElement("div")
      newDiv.setAttribute("id","map2")
      con.appendChild(newDiv)


      map = ''
      latitude = 0
      longitude = 0
      this.count = 0
      var polygonPath = []
      this.positions = []
      for (var user of this.mrUserInfo) {
        if (user.mruUserLat !== null) {
          this.count ++
          var LatLng = new kakao.maps.LatLng(user.mruUserLat, user.mruUserLng)
          var tmp = {
            latlng: LatLng,
            title: user.uName
          }
          polygonPath.push(LatLng)
          latitude += parseFloat(user.mruUserLat)
          longitude += parseFloat(user.mruUserLng)
          this.positions.push(tmp)
        }
      }

      longitude = longitude / this.count
      latitude = latitude / this.count
      console.log(latitude, longitude)

      var container = document.getElementById("map2");
      container.style.width = '100%'
      container.style.height = '300px'
      var options = {
        center: new kakao.maps.LatLng(latitude, longitude),
        level: 14
      }
      map = new kakao.maps.Map(container, options)

      var mapTypeControl = new kakao.maps.MapTypeControl()
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT)
      var zoomControl = new kakao.maps.ZoomControl()
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT)

      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_b.png'
      // var imageSrc = "https://cdn.vuetifyjs.com/images/john.jpg"

      for (var i = 0; i < this.positions.length; i ++) {
        var imageSize = new kakao.maps.Size(24, 35)
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)
        new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: this.positions[i].latlng, // 마커를 표시할 위치
          title : this.positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image : markerImage // 마커 이미지 
        });
        var content = 
          '<div class="mt-7 rounded-pill grey lighten-3">' +
          '  <v-textarea background-color="light-blue">' +
          `    <div>${ this.positions[i].title }</div>` + 
          '  </v-textarea>' +
          '</div>'
          
        var overlay = new kakao.maps.CustomOverlay({
          content: content,
          map: map,
          position: this.positions[i].latlng  
        });
        overlay.setMap(map);
      }
      polygonPath.sort()
      var polygon = new kakao.maps.Polygon({
          path:polygonPath, // 그려질 다각형의 좌표 배열입니다
          strokeWeight: 3, // 선의 두께입니다
          strokeColor: '#39DE2A', // 선의 색깔입니다
          strokeOpacity: 0.8, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
          strokeStyle: 'longdash', // 선의 스타일입니다
          fillColor: '#A2FF99', // 채우기 색깔입니다
          fillOpacity: 0.7 // 채우기 불투명도 입니다
      });

      polygon.setMap(map)

      var imageSrc2 = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"
      var imageSize2 = new kakao.maps.Size(24, 35)
      var markerImage2 = new kakao.maps.MarkerImage(imageSrc2, imageSize2)
      new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(latitude, longitude),
        title : "중간지점 : " + latitude + ", " + longitude,
        image : markerImage2
      });
      map.relayout()
    },
  },
}
</script>

<style>

</style>