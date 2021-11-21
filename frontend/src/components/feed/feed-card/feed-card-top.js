import { UserOutlined } from '@ant-design/icons';
import { Avatar, Space } from 'antd';
import Meta from 'antd/lib/card/Meta';
import Text from 'antd/lib/typography/Text';
import React, { Fragment } from 'react';
import styled from 'styled-components';
import { theme } from '../../../style/theme';

function FeedTop({ author, date }) {
  return (
    // <Meta
    //   style={{ paddingLeft: '16px', paddingRight: '16px' }}
    //   avatar={
    //     <Avatar
    //       icon={<UserOutlined />}
    //       style={{ backgroundColor: `${theme.colorPrimary}` }}
    //       size={theme.fontSizeUserIcon}
    //     />
    //   }
    //   title={author}
    //   description={date}
    // />

    <Space wrap>
      <Avatar
        icon={<UserOutlined />}
        style={{ backgroundColor: `${theme.colorPrimary}` }}
        size={theme.fontSizeUserIcon}
      />
      <Text>{author}</Text>
    </Space>
  );
}

export default FeedTop;
