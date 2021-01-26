<template>

  <div>
    <div class="pt-5 d-flex justify-center mx-5" style="border-bottom: 2px solid black">
      <h5>약속방 만들기</h5>
    </div>
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

    <v-container>
      <div id="map" style="width: 100%; height: 300px;"></div>
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
      <v-row>
        <v-col
          cols="12"
          sm="12"
        >
          <v-date-picker
            v-model="dates"
            multiple
            color="teal"
            full-width
            no-title
            :min="today"
          ></v-date-picker>
        </v-col>
      </v-row>
    </v-container>
    
    <div class="mx-10 d-flex justify-space-between">
      <v-btn
        fab
        dark
        small
        color="teal"
        @click="is_prev"
      >
        <v-icon dark>
          mdi-chevron-double-left
        </v-icon>
      </v-btn>
      <v-dialog
        v-model="dialog"
        persistent
        max-width="290"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            fab
            dark
            small
            color="teal"
            v-bind="attrs"
            v-on="on"
          >
            <v-icon dark>
              mdi-check-bold
            </v-icon>
          </v-btn>
        </template>
        <v-card>
          <v-card-title class="headline">
            방을 만드시겠습니까?
          </v-card-title>
          <v-card-text></v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="green darken-1"
              text
              @click="dialog = false"
            >
              생성
            </v-btn>
            <v-btn
              color="green darken-1"
              text
              @click="dialog = false"
            >
              취소
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>

    
  </div>
</template>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=71f77d07e68b0f6c0464d85d3df14e6c"></script>
<script>
const KAKAO_API_KEY = process.env.VUE_APP_KAKAO_API_KEY
export default {
  name: "MakeSchedule",
  data () {
    return {
      latitude: 36.1299968,
      longitude: 128.34242559999998,
      textContent: '',
      dates: [],
      today: new Date().toISOString().substr(0, 10),
      dialog: false,
      direct: false,
    }
  },
  watch: {
    dates() {
      console.log(this.dates)
    },
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      setTimeout(() => { this.initMap() }, 1000)
    } else {
      this.addKakaoMapScript()
    }
  },
  methods: {
    is_prev(){
      this.$emit('is_prev')
    },
    directSelect(){
      this.direct = !this.direct
    },
    geofind() {
      if(!("geolocation" in navigator)) {
      this.textContent = 'Geolocation is not available.';
      return;
      }
      this.textContent = 'Locating...'
      
      navigator.geolocation.getCurrentPosition(pos => {
        this.latitude = pos.coords.latitude;
        this.longitude = pos.coords.longitude;
        this.textContent = this.latitude + ', ' + this.longitude
        console.log(this.textContent)
      }, err => {
        this.textContent = err.message;
      })
    },
    addKakaoMapScript() {
      const script = document.createElement("script");
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${KAKAO_API_KEY}`;
      document.head.appendChild(script)
    },
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(36.1299968, 128.34242559999998),
        level: 3
      };
      
      var map = new kakao.maps.Map(container, options);
      var mapTypeControl = new kakao.maps.MapTypeControl();
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
      var markers = []

      kakao.maps.event.addListener(map, 'click', function(mouseEvent) {  
          hideMarkers()
          var latlng = mouseEvent.latLng;
          this.latitude = latlng.getLat()
          this.longitude = latlng.getLng()
          console.log(this.latitude, this.longitude)
          addMarker(latlng)
      });
      function setMarkers(map) {
          for (var i = 0; i < markers.length; i++) {
              markers[i].setMap(map);
          }            
      }
      function hideMarkers() {
          setMarkers(null)
      }
      function addMarker(position) {
          var marker = new kakao.maps.Marker({
              position: position
          });
          marker.setMap(map)
          markers.push(marker)
      }
      setTimeout(map.relayout(), 1000)
    },
  },
}
</script>

<style>
</style>