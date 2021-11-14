import React from 'react';
import { Button, Card, Space, Input, Select } from 'antd';
import { POST_SUBMIT } from '../../../constants';
import { theme } from '../../../style/theme';
import FeedTop from './feed-card-top';

const { TextArea } = Input;
const { Option } = Select;

function FeedWrite() {
  const children = [];

  for (let i = 10; i < 36; i++) {
    children.push(
      <Option key={i.toString(36) + i}>{i.toString(36) + i}</Option>
    );
  }

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
          {children}
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
