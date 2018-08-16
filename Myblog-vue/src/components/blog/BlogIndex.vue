<template>
  <div id="bgIndex">
    <el-row style="background-color: cadetblue;">
      <el-col style="text-align: -webkit-center;font-family: 华文彩云;" :xs="5" :sm="5" :md="4" :lg="4" :xl="6">
        <h1 class="lineH60">MC博客</h1>
      </el-col>
      <el-col style="border-left: 2px solid beige;border-right: 2px solid beige;height: 60px;" :xs="12" :sm="12" :md="12" :lg="12"
        :xl="10">
        <ul style="list-style-type: none;margin: 0;padding: 0;" class="lineH60" id="ll">
          <li :class="{activeWhite:index===1}" @click="changePage(1,'/blog/index')">

            首页

          </li>
          <li :class="{activeWhite:index===2}" @click="changePage(2,'/blog/about')" style="position: relative;">
            关于
          </li>
          <li :class="{activeWhite:index===3}" @click="changePage(3,'/blog/growUp')">
            成长
          </li>
          <li :class="{activeWhite:index===4}" @click="changShowStu(4)" style="position: relative;">
            {{study}}
            <ol class="olList" v-if="showStu===true">
              <li @click.stop.prevent="changePageStudy(4,'/blog/Css','CSS')">CSS</li>
              <li @click.stop.prevent="changePageStudy(4,'/blog/Javascript','JAVASCRIPT')">JAVASCRIPT</li>
              <li @click.stop.prevent="changePageStudy(4,'/blog/Java','JAVA')">JAVA</li>
              <li @click.stop.prevent="changePageStudy(4,'/blog/VuePage','VUE')">VUE</li>
              <li @click.stop.prevent="changePageStudy(4,'/blog/SpringBoot','SPRINGBOOT')">SPRINGBOOT</li>
            </ol>
          </li>
          <li :class="{activeWhite:index===5}" @click="changePage(5,'/blog/leaveMessage')">
            留言
          </li>

        </ul>
      </el-col>
      <el-col :xs="7" :sm="7" :md="8" :lg="8" :xl="6">
        <el-input placeholder="请输入内容" v-model="search" class="input-with-select" style="margin-top: 7px;width: 90%;">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <!-- <div style="float: right;line-height: 60px;">
          <el-button type="primary">登录</el-button>
          <el-button type="primary">注册</el-button>
        </div> -->

      </el-col>
    </el-row>
    <el-row style="height: 500px;background-color: springgreen;width:80%;margin: 0 auto;">
      <el-col :span="24">
        <router-view></router-view>
      </el-col>
    </el-row>
  </div>
</template>
<style>
  .el-col-8 {
    height: 60px;
  }

  ul>li {
    float: left;
    font-size: 20px;
    font-family: 华文彩云;
    width: 20%;
    line-height: 60px;
    height: 60px;
    cursor: pointer;
  }

  .lineH60 {
    line-height: 30px !important;
  }

  ul>li:hover {
    background-color: mintcream;
  }

  .activeWhite {
    background-color: white;
  }

  .olList {
    background-color: white;
    width: 100%;
    z-index: 100;
    position: absolute;
    list-style: none;
    padding: 0;
    margin: 0;
  }

  ol>li {
    height: 30px;
    line-height: 30px;
    font-size: 13px;
  }

  ol>li:hover {
    background-color: deepskyblue;
  }

</style>
<script>
  export default {
    data() {
      return {
        search: '',
        index: 1,
        study: '学习',
        showStu: false
      }
    },
    methods: {
      changePage(index, path) {
        // console.log('index>>>>:' + index);
        this.showStu = false;
        this.study = '学习';
        this.index = index;
        this.$router.push(path);
      },
      changePageStudy(index, path, studyName) {
        this.showStu = false;
        this.index = index;
        this.$router.push(path);
        this.study = studyName;
      },
      changShowStu(index) {
        this.index = index;
        this.showStu = !this.showStu;
      }

    },
    mounted() {
      console.log('进来了》》》》》》》》》》》》》》》' + document.URL)
      history.pushState(null, null, document.URL);
      window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
      });
    },
    created() {
      this.$router.push('/blog/index');
    },

  }

</script>
