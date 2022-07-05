<template>
  <div>
    <div id="map"></div>
    <div>
      <v-navigation-drawer
        v-model="rightDrawer"
        :right="right"
        temporary
        fixed
      >
        <v-list>
          <v-list-item @click.native="right = !right">
            <v-list-item-action>
              <v-icon light>
                mdi-repeat
              </v-icon>
            </v-list-item-action>
            <v-list-item-title>Switch drawer (click me)</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </div>
<!--    <base-input>-->
<!--      <el-date-picker v-model="datePicker"-->
<!--                      type="date"-->
<!--                      placeholder="Pick a day">-->
<!--      </el-date-picker>-->
<!--      <el-time-select-->
<!--        v-model="timePicker"-->
<!--        :picker-options="{-->
<!--            start: '00:00',-->
<!--            step: '00:15',-->
<!--            end: '23:59'-->
<!--          }"-->
<!--        placeholder="Select time">-->
<!--      </el-time-select>-->
<!--    </base-input>-->

  </div>

</template>
<style>
#map{
  width:90%;
  height:90vh;
}
.marker {
  background-image: url('../assets/styles/icon.png');
  background-size: cover;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  cursor: pointer;
}
.mapboxgl-canvas {
  position: absolute;
  top: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
}

</style>
<script>
  import mapboxgl from 'mapbox-gl'
  const axios = require('axios').default;
  import { DatePicker, TimeSelect } from 'element-ui'
  import lang from 'element-ui/lib/locale/lang/de'
  import locale from 'element-ui/lib/locale'

  // configure language
  locale.use(lang)

  // import components

  export default {
    components: {
      [DatePicker.name]: DatePicker,
      [TimeSelect.name]: TimeSelect
    },
    data(){
      return{
        dateTimePicker: '',
        marker: {},
        access_token: 'pk.eyJ1IjoibWFyaXVzdGhrb2VsbiIsImEiOiJja3hkOHEyZjI0YTllMnFwemdzdmZqejlwIn0.GRCfDomYwrtPKUEukKoQdQ',
        map:{}
      }
    },

    mounted() {
      this.createMap()
      this.fetch()
    },
    methods:{
      createMap(){
        mapboxgl.accessToken = this.access_token
        this.map = new mapboxgl.Map({
          container: 'map',
          style: 'mapbox://styles/mapbox/outdoors-v11',
          zoom: 13,
          center:[7.1385784,50.9375528]
        })
      },
      async fetch(){
        try{
          const response = await axios.get('http://localhost:8081/controller/geoJson');
          console.log(response);
          for (const feature of response.data.features) {
            // create a HTML element for each feature
            const el = document.createElement('div');
            el.className = 'marker';
            el.addEventListener('click', () =>
            {
              alert(feature.geometry.coordinates);
            })
            // make a marker for each feature and add to the map
            new mapboxgl.Marker(el).setLngLat(feature.geometry.coordinates).addTo(this.map);
            console.log(feature.geometry.coordinates);
          }
/*
          this.marker = response;
          for (const data in marker){

          }
 */
        } catch (error){
          console.error(error);
        }
      }
    }
  }


</script>

