<template>
  <div>
    <v-tabs
      color="indigo accent-2"
      centered
      fixed-tabs
      slider-color="indigo accent-2"
    >
      <v-tab>진행중</v-tab>
      <v-tab>완료</v-tab>

      <v-tab-item>
        <v-card
          class="mx-auto mt-3"
          v-for="(value, idx) in doing_temp"
          :key="idx"
          @click="goDetail(value.mrNo)"
        >
          <v-img 
          height="200px"
          :src="type[value.mrCategory][1]"
          style="filter: brightness(50%);">
          </v-img>
        <v-fade-transition>
            <v-overlay
              absolute >
              <div class="d-flex flex-column mt-5">
                <div class="d-flex justify-center"><v-icon class="mb-1">{{type[value.mrCategory][0]}} </v-icon> {{ value.mrCategory}} 약속</div>
                <div class="d-flex justify-center"><h4>{{ value.mrName }}</h4></div>
                <div class="d-flex justify-center">{{ value.mrDateStart }} ~ {{ value.mrDateEnd }}</div>
                <div class="d-flex justify-center">5명</div>
              </div>
            </v-overlay>
          </v-fade-transition>
        </v-card>
        <infinite-loading @infinite="doingInfiniteHandler"></infinite-loading>
      </v-tab-item>
      <v-tab-item>
        <v-card
          class="mx-auto mt-3"
          v-for="(value, idx) in done_temp"
          :key="idx"
          @click="goDetail(value.mrNo)"
        >
          <v-img 
          height="200px"
          :src="type[value.mrCategory][1]"
          style="filter: brightness(50%);">
          </v-img>
        <v-fade-transition>
            <v-overlay
              absolute >
              <div class="d-flex flex-column mt-5">
                <div class="d-flex justify-center"><v-icon class="mb-1">{{type[value.mrCategory][0]}} </v-icon> {{ value.mrCategory}} 약속</div>
                <div class="d-flex justify-center"><h4>{{ value.mrName }}</h4></div>
                <div class="d-flex justify-center">{{ value.mrDateStart }} ~ {{ value.mrDateEnd }}</div>
                <div class="d-flex justify-center">5명</div>
              </div>
            </v-overlay>
          </v-fade-transition>
        </v-card>
        <infinite-loading @infinite="doneInfiniteHandler"></infinite-loading>
      </v-tab-item>
    </v-tabs>
    <div class="d-flex justify-center">
      <back-to-top bottom="65px" right="" style="display: block !important;">
        <v-btn fab dark small color="teal">
          <v-icon dark>mdi-chevron-up</v-icon>
        </v-btn>
      </back-to-top>
    </div>
  </div>
</template>

<script>
import InfiniteLoading from 'vue-infinite-loading'
import BackToTop from 'vue-backtotop'
import moment from 'moment'
const axios = require('axios');

export default {
  name: "Main",
  data() {
    return {
      doing_list: [],
      done_list: [],
      doing_temp: [],
      done_temp: [],
      type: {
        '밥': ['mdi-food', 'https://www.gyeongju.go.kr/upload/content/thumb/20200529/A42F50C69A8A4DDB94DA408C290735C1.jpg'],
        '카페': [ 'mdi-coffee', 'http://www.lightingnews.net/images/theme/cafe_01.png'],
        '술': ['mdi-glass-mug-variant', 'https://img.lovepik.com/photo/50011/5863.jpg_wh860.jpg'],
        '스터디': ['mdi-book-open-page-variant', 'https://modo-phinf.pstatic.net/20180304_283/1520151276251GkP1Q_JPEG/mosaOtd1XG.jpeg?type=w720'],
        '놀거리': ['mdi-snowboard', 'https://www.travel.taipei/image/65598/1024x768'],
        '기타': ['mdi-dots-horizontal', 'http://img.rflogix.com/agm/main/1024/10_1_20200407112854.jpg'],
      }
    };
  },
  components: {
    InfiniteLoading,
    BackToTop,
  },
  created() {
    this.getRoomList()
    console.log(this.list)
  },
  methods: {
    doingInfiniteHandler($state) {
      setTimeout(() => {
        for (let i = 1; i <= 3; i++) {
          if (this.doing_list.length > 0) {
            this.doing_temp.push(this.doing_list.shift());
          } else {
            $state.complete();
          }
        }
        $state.loaded();
      }, 1000);
    },
    doneInfiniteHandler($state) {
      setTimeout(() => {
        for (let i = 1; i <= 3; i++) {
          if (this.done_list.length > 0) {
            this.done_temp.push(this.done_list.shift());
          } else {
            $state.complete();
          }
        }
        $state.loaded();
      }, 1000);
    },
    getRoomList() {
      axios.get(`http://i4d107.p.ssafy.io:8000/letsmeet/main?uNo=${this.$store.state.uNo}`)
      .then((res)=> {
        const data = res.data
        for (var val of data) {
          if (val.mrDateEnd < moment().format('YYYY-MM-DD')){
            this.done_list.push(val)
          } else {
            this.doing_list.push(val)
          }
        }
        for (var i=0 ; i<3 ; i++) {
          if (this.done_list.length > 0) {
            this.done_temp.push(this.done_list.shift());
          }
          if (this.doing_list.length > 0) {
            this.doing_temp.push(this.doing_list.shift());
          }
        }
      })
      .catch((err) => {
        console.log(err)
      })
    },
    goDetail(mrNo) {
      this.$router.push({name:"MeetingRoom", params:{"id":mrNo}})
    }
  },
}
</script>

<style>

</style>