<template>
  <v-container>
    <v-list>
      <v-subheader>멤버 목록</v-subheader>
      <v-list-item-group v-model="model">
        <v-list-item
          v-for="item in items"
          :key="item.title"
        >
          <v-list-item-avatar>
            <v-img :src="item.avatar"></v-img>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="item.title"></v-list-item-title>
          </v-list-item-content>

          <v-list-item-icon>
            <v-icon
              v-if="item.icon"
              color="pink"
            >
              mdi-star
            </v-icon>
          </v-list-item-icon>
        </v-list-item>
      </v-list-item-group>
    </v-list>
    <v-btn
      block
      color="indigo accent-2"
      class="white--text"
    >
      멤버 추가
      <v-icon
        right
        dark
      >
        mdi-account-plus
      </v-icon>
    </v-btn>
  </v-container>
</template>

<script>
export default {
  name: "Member",
  data () {
    return {
      items: [
        { icon: true, title: 'Jason Oner', avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg' },
        { title: 'Travis Howard', avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg' },
        { title: 'Ali Connors', avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg' },
        { title: 'Cindy Baker', avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg' },
      ],
      model: null,
    }
  },
}
</script>

<style>

</style>