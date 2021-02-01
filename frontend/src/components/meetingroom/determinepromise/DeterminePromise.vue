<template>
  <v-container>
    <v-subheader>내 약속 일정 선택</v-subheader>
    <v-container>
      <MyPromise />
    </v-container>
    <hr>
    <v-subheader>약속 가능 날짜</v-subheader>
    <v-date-picker
      v-model="date2"
      :event-color="date => date[9] % 2 ? 'red' : 'yellow'"
      :events="functionEvents"
      full-width
      no-title
      color="#536DFE"
      readonly
      min="2021-02-01"
      max="2021-02-05"
    ></v-date-picker>
    <hr>
    <v-subheader>출발 장소</v-subheader>
    <v-container>
      홍길동 : 인동초등학교 <br>
      임꺽정 : 삼성전자 <br>
      춘향 : IWC <br>
    </v-container>
  </v-container>
</template>



<script>
import MyPromise from "./MyPromise.vue";
export default {
  name: "DeterminePromise",
  components: {
    MyPromise,
  },
  data: () => ({
    arrayEvents: null,
    // date2: new Date().toISOString().substr(0, 10),
    date2: ['2021-02-01', '2021-02-02', '2021-02-03', '2021-02-04', '2021-02-05']
  }),

  mounted () {
    this.arrayEvents = [...Array(6)].map(() => {
      const day = Math.floor(Math.random() * 30)
      const d = new Date()
      d.setDate(day)
      return d.toISOString().substr(0, 10)
    })
  },

  methods: {
    functionEvents (date) {
      const [,, day] = date.split('-')
      if ([1, 2, 3].includes(parseInt(day, 10))) return true
      if ([1, 2, 4, 5].includes(parseInt(day, 10))) return ['green accent-3']
      return false
    },
  },
}
</script>

<style>

</style>