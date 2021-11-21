import { Card, Input, Space } from 'antd';
import React from 'react';
import styled from 'styled-components';
import FeedBottom from '../feed/feed-card/feed-card-bottom';
import FeedTop from '../feed/feed-card/feed-card-top';
import FeedComment from '../feed/feed-card/feed-comment';

const { TextArea } = Input;

const Wrapper = styled.div`
  height: 100%;
  max-height: 100%;
  flex-basis: 360px;
  flex-grow: 2;
  flex-shrink: 2;
  display: flex;
  flex-direction: column;
`;

const CardAntd = styled(Card)`
  /* border-radius: 0px; */
`;

function FeedDetailComments() {
  return (
    <Wrapper>
      <CardAntd style={{ display: 'flex', flexDirection: 'column' }}>
        <FeedTop author={'홍길동'} date={''} />
        <br />
        <br />
        <FeedBottom like={2} comment={3} />
      </CardAntd>
      <CardAntd
        style={{
          flexGrow: 1,
          maxHeight: '370px',
          overflow: 'auto',
        }}
      >
        <FeedComment
          author={'홍길동'}
          comment={'반가워요 사진 좋네요'}
          regDate={'2일전'}
        />
        <FeedComment
          author={'홍길순'}
          comment={
            '반가워요 사진 좋네요반가워요 사진 좋네요반가워요 사진 좋네요반가워요 사진 좋네요반가워요 사진 좋네요반가워요 사진 좋네요반가워요 사진 좋네요반가워요 사진 좋네요'
          }
          regDate={'1일전'}
        />
        <FeedComment
          author={'홍길동'}
          comment={'반가워요 사진 좋네요'}
          regDate={'방금'}
        />
        <FeedComment
          author={'홍길동'}
          comment={'반가워요 사진 좋네요'}
          regDate={'방금'}
        />
        <FeedComment
          author={'홍길동'}
          comment={'반가워요 사진 좋네요'}
          regDate={'방금'}
        />
      </CardAntd>
      <CardAntd>
        <TextArea />
      </CardAntd>
    </Wrapper>
  );
}

export default FeedDetailComments;
