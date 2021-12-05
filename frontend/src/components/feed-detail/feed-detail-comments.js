import React from 'react';
import { UserOutlined } from '@ant-design/icons';
import { Avatar, Button, Card, Input, Space } from 'antd';
import styled from 'styled-components';
import FeedBottom from '../feed/feed-card/feed-card-bottom';
import FeedTop from '../feed/feed-card/feed-card-top';
import FeedComment from '../feed/feed-card/feed-comment';
import { theme } from '../../style/theme';

const { TextArea } = Input;

const Wrapper = styled.div`
  height: calc(100vh - 70px);
  flex-basis: 360px;
  flex-grow: 2;
  flex-shrink: 2;
  display: flex;
  flex-direction: column;
`;

const CardAntd = styled(Card)`
  /* border-radius: 0px; */
`;

const CommentWrite = styled(Card)`
  border-top: 0;
  border-radius: 0;

  .ant-card-body {
    padding: 13px;
  }
`;

function FeedDetailComments() {
  return (
    <Wrapper>
      <CardAntd
        style={{
          display: 'flex',
          flexDirection: 'column',
          borderTop: 0,
          borderRadius: 0,
        }}
      >
        <FeedTop author={'홍길동'} date={''} />
        <br />
        <br />
        <FeedBottom like={2} comment={3} />
      </CardAntd>
      <CardAntd
        style={{
          flexGrow: 1,
          overflow: 'auto',
          borderRadius: 0,
          borderTop: 0,
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
      <CommentWrite>
        <Space
          style={{
            alignItems: 'flex-start',
            display: 'flex',
            flexDirection: 'row',
          }}
          size={7}
        >
          <Avatar
            icon={<UserOutlined />}
            style={{ backgroundColor: `${theme.colorPrimary}` }}
            size={40}
          />
          <Space size={8} direction={'vertical'} style={{ minWidth: '100%' }}>
            <TextArea
              style={{
                backgroundColor: '#e4e4e4',
                width: 287,
                height: '120px',
              }}
            />
            <Button type={'primary'} style={{ float: 'right' }}>
              보내기
            </Button>
          </Space>
        </Space>
      </CommentWrite>
    </Wrapper>
  );
}

export default FeedDetailComments;
