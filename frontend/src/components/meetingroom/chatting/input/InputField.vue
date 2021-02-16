<template>
  <div class="input__field">
    <input
      v-model="value"
      type="text"
      placeholder="채팅을 입력해주세요."
      autofocus
      @keydown.enter.prevent="send"><br>
  </div>

</template>

<script>
export default {
  name: 'InputField',
  data: function () {
  return {
    value: '',
    }
  },
  watch: {
    value() {
      this.$emit('input_message', this.value)
    }
  },
  methods: {
    send () {
      this.$emit('newOwnMessage')
      this.value = ''
    },
  }
}
</script>

<style>

</style>
