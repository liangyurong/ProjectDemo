
<!--

知识点


-->

<template>
    <div>
         <div>
             <label>{{inputVal}}</label>
         </div>
    </div>
</template>

<script>
export default {
  name: 'myradio',
  data () {
    return{
      inputVal:new Date().getTime()//Get timestamp
    }
  },
  methods: {

  },
  computed:{

  }

}
</script>

<style scoped>

</style>
