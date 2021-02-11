<template>
  <div>
    <v-list>
      <template v-for="(item, index) in items">
        <v-subheader
          v-if="item.header"
          :key="index"
        ></v-subheader>
        <v-divider
          v-else-if="item.divider"
          :key="index"
          :inset="item.inset"
        ></v-divider>
        <v-list-item
          v-else
          :key="index"
        >
          <v-list-item-avatar>
            <v-img :src="item.avatar"></v-img>
          </v-list-item-avatar>
          <v-list-item-content>
            <v-list-item-title>{{item.title}}</v-list-item-title>
            <v-rating
              :value="item.rating"
              color="yellow darken-3"
              dense
              readonly
              size="1rem"
            ></v-rating>
            <v-list-item-subtitle>{{item.subtitle}}</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list> 

    <div class="text-center">
      <v-pagination
        v-model="page"
        :length="len"
        color="indigo accent-2"
      ></v-pagination>
    </div>
    <v-container>
      <v-textarea
        solo
        name="input-7-3"
        label="comments"
        style="position: relative; top: 1.2rem;"
        rows="3"
      ></v-textarea>
      <v-row class="d-flex align-center">
        <v-col cols=7 class="d-flex justify-center">
          <v-rating
            v-model="rating"
            color="yellow darken-3"
            background-color="yellow"
            dense
            icon-label="custom icon label text {0} of {1}"
          ></v-rating>
        </v-col>
        <v-col cols=5 class="d-flex justify-center">
          <v-btn
            class="ma-2"
            outlined
            color="indigo"
          >
            리뷰 작성
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "StoreReview",
  data () {
    return {
      page: 1,
      rating: 5,
      items: [],
      len: '',
      comments: [
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
        { divider: true, inset: true },
        {
          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',
          title: '성헌',
          rating: 5,
          subtitle: `맛이 매우 좋네요`,
        },
      ],
    }
  },
  created() {
    this.items = this.comments.slice((this.page-1)*10, this.page*10-1)
      console.log(this.items)
    this.len = parseInt(this.comments.length / 10) + 1
    console.log(this.len)
  },
  props: {
    place: Object
  },
  watch: {
    page() {
      this.items = this.comments.slice((this.page-1)*10, this.page*10-1)
      console.log(this.items)
    }
  }
}
</script>

<style lang="scss">
  $pagination-navigation-margin : .2rem 5px !default;
</style>