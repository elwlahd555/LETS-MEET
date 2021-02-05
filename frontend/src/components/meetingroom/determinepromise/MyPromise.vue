<template>
  <div>
    <v-dialog
      v-model="dialog"
      max-width="90%"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          block
          v-bind="attrs"
          v-on="on"
          color="#536DFE"
          class="white--text"
        >
          약속 일정 선택
          <v-icon
            right
            dark
          >
            mdi-calendar-text
          </v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>약속 일정 선택</v-card-title>
        <v-divider></v-divider>
        <v-container>
          <v-row class="d-flex align-center mx-0">
            <v-col
              cols="12"
              class="d-flex justify-start"
            >
              <span>출발 장소</span>
            </v-col>
            <v-col
              cols="6"
              class="d-flex justify-start flex-column"
            >
              <v-btn block @click="geofind">
                현재 위치
              </v-btn>
            </v-col>
            <v-col
              cols="6"
              class="d-flex justify-start flex-column"
            >
              <v-btn block @click="directSelect">
                직접 위치 선정
              </v-btn>
            </v-col>
          </v-row>
        </v-container>
        <v-container v-show="direct">
          <div id="map"></div>
        </v-container>
        <v-container>
          <v-row class="d-flex align-center mx-0">
            <v-col
              cols="12"
              class="d-flex justify-start"
            >
              <span>약속 가능한 날짜</span>
            </v-col>
          </v-row>
        </v-container>     
        <v-container>
          <v-col
            cols="12"
            sm="12"
          >
            <v-date-picker
              v-model="dates"
              multiple
              color="#536DFE"
              full-width
              no-title
              :min="min"
              :max="max"
            ></v-date-picker>
          </v-col>
          <v-col
            cols="12"
          >
            <v-text-field
              v-model="dates"
              label="약속 기간"
              prepend-icon="mdi-calendar"
              readonly
            ></v-text-field>
          </v-col>
        </v-container>
        <v-divider></v-divider>
        <v-card-actions>
          <v-row justify="end" class="mb-1 mx-2">
            <v-btn
              color="blue darken-1"
              outlined
              @click="confirmPormise"
              class="mx-2"
            >
              확인
            </v-btn>
            <v-btn
              color="red darken-1"
              outlined
              @click="dialog = false"
            >
              닫기
            </v-btn>
          </v-row>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
// const KAKAO_API_KEY = process.env.VUE_APP_KAKAO_API_KEY
const KAKAO_API_KEY = '71f77d07e68b0f6c0464d85d3df14e6c'
var map = ''
const axios = require('axios');

export default {
  name: "MyPromise",
  data () {
    return {
      mrNo: '',
      dialogm1: '',
      dialog: false,
      latitude: '36.103764999999996',
      longitude: '128.4204923',
      textContent: '',
      dates: [],
      min: this.roomInfo.mrDateStart,
      max: this.roomInfo.mrDateEnd,
      direct: false,
      flag: true,
    }
  },
  props: {
    roomInfo: Array
  },
  watch: {
    dates() {
      console.log(this.dates)
    },
  },
  mounted() {
    this.addKakaoMapScript()
    this.mrNo = this.$route.params.id
  },
  methods: {
    directSelect(){
      this.direct = !this.direct
      if (this.direct && this.flag) {
        setTimeout(() => { this.initMap() }, 100)
      }
      this.flag = false
    },
    geofind() {
      if(!("geolocation" in navigator)) {
      this.textContent = 'Geolocation is not available.'
      return;
      }
      this.textContent = 'Locating...'
      
      navigator.geolocation.getCurrentPosition(pos => {
        this.latitude = pos.coords.latitude
        this.longitude = pos.coords.longitude
        this.textContent = this.latitude + ', ' + this.longitude
        console.log(this.textContent)
      }, err => {
        this.textContent = err.message
      })
      this.dialogm1 = true
    },
    addKakaoMapScript() {
      const script = document.createElement("script")
      script.onload = () => kakao.maps.load()
      script.src =
        `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${KAKAO_API_KEY}`
      document.head.appendChild(script)
    },
    initMap() {
      this.dialogm1 = true
      var container = document.getElementById("map");
      container.style.width = '100%'
      container.style.height = '300px'
      var options = {
        center: new kakao.maps.LatLng(this.latitude, this.longitude),
        level: 4
      }
      map = new kakao.maps.Map(container, options)
      var mapTypeControl = new kakao.maps.MapTypeControl()
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT)
      var zoomControl = new kakao.maps.ZoomControl()
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT)
      var markers = []
      addMarker(options['center'])
      map.setCenter(options['center'])

      kakao.maps.event.addListener(map, 'click', function(mouseEvent) {  
        map.relayout()
        hideMarkers()
        var latlng = mouseEvent.latLng
        this.latitude = latlng.getLat()
        this.longitude = latlng.getLng()
        addMarker(latlng)
        console.log(latlng)
      })
      function setMarkers(map) {
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(map)
        }            
      }
      function hideMarkers() {
        setMarkers(null)
      }
      function addMarker(position) {
        var marker = new kakao.maps.Marker({
            position: position
        })
        marker.setMap(map)
        markers.push(marker)
      }
    },
    confirmPormise() {
      if (this.dialogm1 && this.dates.length > 0){
        this.dialog = false
        this.dates.sort()
        const data = {
          mruMrNo: this.mrNo,
          mruUNo: this.$store.state.uNo,
          mruUserDates: this.dates.join('/'),
          mruUserLat: this.latitude,
          mruUserLng: this.longitude
        }
        console.log(data)
        axios.put(`http://localhost:8000/letsmeet/meetingRoomUser/set`, data)
          .then(()=> {
            alert('일정 선택이 완료되었습니다.')
            this.$router.push({ name: 'Main'});
            this.$emit('refresh')
          })
          .catch(() => {
            alert('일정 선택이 실패했습니다.')
          })
      }else {
        alert("데이터를 모두 입력해주세요.")
      }
    },
  },
}
</script>

<style>

</style>