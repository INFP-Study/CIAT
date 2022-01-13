import React, { useEffect, useState } from 'react';
import { Button, Card, Space, Input, Select } from 'antd';
import { POST_SUBMIT } from '../../../constants';
import { theme } from '../../../style/theme';
import FeedTop from './feed-card-top';
import { useSelector } from 'react-redux';

const { TextArea } = Input;
const { Option } = Select;

function FeedWrite() {
  const [categoryList, setCategoryList] = useState([]);

  //카테고리 리스트 가져오기
  const _categoryList = useSelector((state) => state.menu.categoryList);

  //useSelector로 가져온 카테고리 리스트 state에 담기
  useEffect(() => {
    setCategoryList(_categoryList);
  }, [_categoryList]);

  const getCategory = (categoryList) => {
    return categoryList.map((category) => (
      <Option key={category.id}>{category.name}</Option>
    ));
  };

  function handleChange(value) {
    console.log(`selected ${value}`);
  }

  return (
    <Card style={{ width: 652, borderColor: `${theme.colorLine2}` }}>
      <Space direction="vertical" size="small" style={{ width: '100%' }}>
        <FeedTop author="작성자" date="11월 12일" />
        <Select
          mode="showSearch"
          style={{ width: 210 }}
          placeholder="주제를 선택해 주세요."
          onChange={handleChange}
        >
          {getCategory(categoryList)}
        </Select>
        <TextArea rows={3} autoSize={false} allowClear={true} />
        <Button type="primary" style={{ float: 'right' }}>
          {POST_SUBMIT}
        </Button>
      </Space>
    </Card>
  );
}

export default FeedWrite;
