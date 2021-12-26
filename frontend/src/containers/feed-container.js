import React, { useEffect, useState } from 'react';
import { Space } from 'antd';
import styled from 'styled-components';
import FeedWrite from '../components/feed/feed-card/feed-card-write';
import Feed from '../components/feed/feed';
import { useDispatch, useSelector } from 'react-redux';
import { getFeedList } from '../store/feed';

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function FeedContainer() {
  const [feeds, setFeeds] = useState([]);

  const dispatch = useDispatch();

  useEffect(() => {
    dispatch({ type: getFeedList.type });
  }, []);

  const _feeds = useSelector((state) => state.feed.feedList);

  useEffect(() => {
    setFeeds(_feeds);
  }, [_feeds]);

  return (
    <Wrapper>
      <Space direction="vertical" size={13}>
        <FeedWrite />
        <Feed contents={feeds} />
      </Space>
    </Wrapper>
  );
}

export default FeedContainer;
