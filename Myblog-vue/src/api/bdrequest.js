import request from './requestAxios'

function getBdSearchData(searchCondition, page) {
  return request({
    url: '/bd/getSearch',
    method: 'post',
    params: {
      searchCondition: searchCondition,
      page: page
    }
  })

}
export {
  getBdSearchData
}
