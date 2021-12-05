import React from 'react';
import styled from 'styled-components';
import FeedDetailSlide from '../components/feed-detail/feed-detail-slide';
import FeedDetailComments from '../components/feed-detail/feed-detail-comments';

const Wrapper = styled.div`
  display: flex;
  flex-flow: row;
  align-items: stretch;
  height: calc(100vh - 70px);
  max-height: calc(100vh - 70px);
  margin: -48px -40px -24px;
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
