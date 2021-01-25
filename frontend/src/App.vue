<template>
  <v-app>
    <div>
      <v-app-bar
        color="white"
        dense
        dark
        fixed
        style="z-index:10;"
      >
        <v-toolbar-title><img src="./assets/images/logo.png" 
        style="width: 35%; max-height: 50px; max-width: 200px;">
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn icon>
          <v-icon style="color: black;">mdi-magnify</v-icon>
        </v-btn>

        <v-menu
          left
          bottom
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              icon
              style="color: black;"
              v-bind="attrs"
              v-on="on"
            >
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>

          <v-list>
            <v-list-item
              v-for="n in 5"
              :key="n"
              @click="() => {}"
            >
              <v-list-item-title>Option {{ n }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-app-bar>
    </div>
    
    <v-main>
      <router-view class="mt-14 mb-13"></router-view>
    </v-main>

    <v-bottom-navigation
      :value="value"
      color="teal"
      dense
      grow
      fixed
      style="z-index:10;"
    >
      <v-btn>
        <router-link class="ro" :to="{ name: 'Main' }"><v-icon>mdi-home</v-icon></router-link>
      </v-btn>
      <v-btn>
        <v-icon>mdi-calendar</v-icon>
      </v-btn>
      <v-btn>
        <router-link class="ro" :to="{ name: 'MakeMeeting' }"><v-icon>mdi-plus-circle</v-icon></router-link>
      </v-btn>
      <v-btn>
        <v-icon>mdi-bell</v-icon>
      </v-btn>
      <v-btn>
        <v-icon>mdi-account-circle</v-icon>
      </v-btn>
    </v-bottom-navigation>
  </v-app>
</template>


<script>

export default {
  name: 'App',

  components: {

  },

  data: () => ({ value: 0 }),
  methods: {
  }
};
</script>

<style>
  @font-face {
    font-family: 'LotteMartHappy';
    font-style: normal;
    font-weight: 700;
    src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyBold.woff') format('woff');
  }

  #app {
    font-family: 'LotteMartHappy', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    /* text-align: center; */
  }

  .ro {
    text-decoration: none !important;
    color: inherit !important;
  }
</style>