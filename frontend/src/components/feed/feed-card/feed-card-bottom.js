import { SmileOutlined } from '@ant-design/icons';
import { Space } from 'antd';
import React from 'react';
import { theme } from '../../../style/theme';

function FeedBottom({ like, comment }) {
  return (
    <div
      style={{
        marginLeft: 16,
        marginRight: 16,
        display: 'flex',
        justifyContent: 'space-between',
      }}
    >
      <div>
        <Space size="middle">
          <SmileOutlined style={{ fontSize: `${theme.fontSizeIcon}` }} />
          {like}개
        </Space>
      </div>
      <div>댓글 {comment}개</div>
    </div>
  );
}

export default FeedBottom;
