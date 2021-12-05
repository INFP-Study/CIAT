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
    <>
      <Space wrap size={10}>
        <Avatar
          icon={<UserOutlined />}
          style={{ backgroundColor: `${theme.colorPrimary}` }}
          size={theme.fontSizeUserIcon}
        />

        <Text
          style={{
            fontSize: `${theme.fontSizeBody01}`,
            fontWeight: `${theme.weightMid}`,
          }}
        >
          {author}
        </Text>

        <Text>08월 20일</Text>
      </Space>
    </>
  );
}

export default FeedTop;
