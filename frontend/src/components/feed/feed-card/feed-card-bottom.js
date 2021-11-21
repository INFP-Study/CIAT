import { SmileOutlined } from '@ant-design/icons';
import { Space } from 'antd';
import React from 'react';
import { theme } from '../../../style/theme';

function FeedBottom({ like, comment }) {
  return (
    <div
      style={{
        display: 'flex',
        justifyContent: 'space-between',
      }}
    >
      <Space>
        <SmileOutlined style={{ fontSize: `${theme.fontSizeIcon}` }} />
        좋아요 {like}
      </Space>

      <Space>댓글 {comment}</Space>
    </div>
  );
}

export default FeedBottom;
