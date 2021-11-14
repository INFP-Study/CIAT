import React from 'react';
import styled from 'styled-components';
import FeedDetailComments from '../components/feed-detail/feed-detail-comments';
import FeedDetailSlide from '../components/feed-detail/feed-detail-slide';

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
`;

function FeedDetailContainer() {
  return (
    <Wrapper>
      <FeedDetailSlide />
      <FeedDetailComments />
    </Wrapper>
  );
}

export default FeedDetailContainer;
