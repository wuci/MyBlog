<template>
  <div class="content">


    <el-row style="width: 80% !important;margin: 0 auto !important;">
      <h2 style="font-family: STLiti;margin: 20px;">MC搜一搜</h2>
      <el-col :span="24">
        <div class="grid-content bg-purple">
          <el-input placeholder="请输入搜索内容" v-model="searchCondition" class="input-with-select" @input="getBdSearchData">
            <el-button slot="append" style="font-family: STLiti;">搜一搜
            </el-button>
          </el-input>

        </div>

      </el-col>
      <ul>
        <div class="li1">
          <li v-for="(item,index) in searchList" :key="index" :value="item.href">
            <a :href="item.href" target="_blank">{{index+1}}、 {{item.title | filterContent}}</a>
          </li>
        </div>
        <div class="li2" v-if="searchList.length>0">

          <el-button @click="pageSearch(0)">首页</el-button>
          <el-button @click="pageSearch(1)">上一页</el-button>
          <el-button @click="pageSearch(2)">下一页</el-button>
        </div>
      </ul>

    </el-row>
    <el-row>
      <el-col :span="24" style="position:fixed; bottom:0;">
        © CopyRight 2018 wmlhome.cn 版权所有 mcxxx
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import {
    getBdSearchData
  } from '../api/bdrequest'
  export default {
    filters: {
      filterContent(inParams) {
        if (inParams.length > 15) {
          return inParams.substring(0, 16) + "..." + inParams.substring(inParams.length - 3, inParams.length);
        } else {
          return inParams;
        }

      }
    },
    name: 'BdSearch',
    data() {
      return {
        page: 0,
        searchCondition: 'QQ',
        searchList: []
      }
    },
    methods: {

      getBdSearchData() {
        if (this.searchCondition === '') {
          return;
        }
        getBdSearchData(this.searchCondition, this.page * 10).then(response => {
          // console.log('返回的参数为:' + JSON.stringify(response.data));
          this.searchList = response.data.results;
          // console.log('size:' + this.searchList.length);
        }).catch(err => {
          console.log('出异常了>>>>:' + err);
          this.$message.error("网络异常，请重新尝试!");
        });
      },
      pageSearch(ele) {
        console.log('ele>>：' + ele);
        if (ele === 0) {
          this.page = 0;
        } else if (ele === 1) {
          this.page = (this.page - 1);
          if (this.page < 0) {
            this.page = 0;
          }
        } else {
          this.page = (this.page + 1);
        }
        this.getBdSearchData();
      }
    },
    created() {
      this.getBdSearchData();
    },
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>


</style>
<style>
  .content {
    width: 100%;
    height: 100%;
    background: url(../../static/img/1.png);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center;
  }

  ul {
    list-style-type: none;
    margin-top: 50px;
    height: 100%;
  }

  ul>.li1,
  .li2>li {
    text-align: left;
  }

  ul>.li1>li {
    margin-top: 15px;
  }

  ul>.li2>li {
    float: left;
  }

  .li1 {
    padding-top: 5px;
  }

  .li2 {
    margin-top: 20px;
    padding-bottom: 10px;
  }

  a {
    text-decoration: none;
    color: mintcream !important;
  }

  a:hover {
    color: aqua !important;
  }

  a:active {
    color: red !important;
  }

</style>
