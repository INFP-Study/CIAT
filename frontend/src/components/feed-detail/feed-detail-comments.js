import React from 'react';
import styled from 'styled-components';
import FeedTop from '../feed/feed-card/feed-card-top';

const Wrapper = styled.div`
  height: 100%;
  border: 1px solid blue;
  flex-basis: 360px;
  flex-grow: 2;
  flex-shrink: 0;
`;

function FeedDetailComments() {
  return <Wrapper>{/* <FeedTop author={'홍길동'} date={''} /> */}</Wrapper>;
}

export default FeedDetailComments;
