import { SmileOutlined } from '@ant-design/icons';
import { Space } from 'antd';
import React from 'react';
import { theme } from '../../../style/theme';

function FeedBottom({ like, comment, isLike }) {
  return (
    <div
      style={{
        display: 'flex',
        justifyContent: 'space-between',
      }}
    >
      <Space>
        <SmileOutlined
          style={{
            fontSize: `${theme.fontSizeIcon}`,
            color: `${isLike ? theme.colorPrimary : theme.colorText}`,
          }}
        />
        <span
          style={{ color: `${isLike ? theme.colorPrimary : theme.colorText}` }}
        >
          {isLike ? `${like + 1}개` : `${like}개`}
        </span>
      </Space>

      <Space>{`댓글 ${comment}개`}</Space>
    </div>
  );
}

export default FeedBottom;
