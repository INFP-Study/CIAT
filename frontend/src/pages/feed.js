import React from 'react';
import { BackTop } from 'antd';
import FeedContainer from '../containers/feed-container';
import { theme } from '../style/theme';
import { UpOutlined } from '@ant-design/icons';

const upButton = {
  height: 50,
  width: 50,
  lineHeight: '50px',
  borderRadius: '50%',
  backgroundColor: `${theme.colorPrimary}`,
  color: '#fff',
  textAlign: 'center',
  fontSize: 16,
};

function Feed() {
  return (
    <>
      <BackTop>
        <UpOutlined style={upButton} />
      </BackTop>
      <FeedContainer />
    </>
  );
}

export default Feed;
