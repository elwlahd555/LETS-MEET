<template>
  <div
    class="input__button"
    @click="send">
    보내기
  </div>
</template>

<script>

export default {
  name: 'InputButton',
  methods: {
    send () {
      this.$emit('newOwnMessage')
    }
  }
}
</script>

<style>

</style>
