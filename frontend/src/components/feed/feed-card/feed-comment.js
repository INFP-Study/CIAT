import React from 'react';
import { UserOutlined } from '@ant-design/icons';
import { Avatar, Card, Space } from 'antd';
import Text from 'antd/lib/typography/Text';
import { theme } from '../../../style/theme';

function FeedComment({ author, comment, regDate }) {
  return (
    <Space
      style={{
        display: 'flex',
        flexDirection: 'row',
        alignItems: 'flex-start',
      }}
    >
      <Avatar
        icon={<UserOutlined />}
        style={{ backgroundColor: `${theme.colorPrimary}` }}
        size={theme.fontSizeUserIcon}
      />
      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
        }}
      >
        <Space
          direction="vertical"
          style={{
            backgroundColor: `${theme.colorComment}`,
            padding: '10px',
            borderRadius: '10px',
          }}
          value="2"
        >
          <Text style={{ fontWeight: `${theme.weightBold}` }}>{author}</Text>
          <Text>{comment}</Text>
        </Space>
        <Text style={{ padding: '0px 10px' }}> {regDate}</Text>
      </div>
    </Space>
  );
}

export default FeedComment;
