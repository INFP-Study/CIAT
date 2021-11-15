import React from 'react';
import styled from 'styled-components';
import FeedDetailComments from '../components/feed-detail/feed-detail-comments';
import FeedDetailSlide from '../components/feed-detail/feed-detail-slide';

const Wrapper = styled.div`
  background-color: red;
  display: flex;
  flex-direction: row;
  margin: -48px -40px -24px;
  height: 100vh;
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
