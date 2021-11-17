import { UserOutlined } from '@ant-design/icons';
import { Avatar } from 'antd';
import Meta from 'antd/lib/card/Meta';
import React from 'react';
import { theme } from '../../../style/theme';

function FeedTop({ author, date }) {
  return (
    <Meta
      style={{ paddingLeft: '16px', paddingRight: '16px' }}
      avatar={
        <Avatar
          icon={<UserOutlined />}
          style={{ backgroundColor: `${theme.colorPrimary}` }}
          size={theme.fontSizeUserIcon}
        />
      }
      title={author}
      description={date}
    />
  );
}

export default FeedTop;
