import React from 'react';
import {
  MessageOutlined,
  PaperClipOutlined,
  SmileOutlined,
  UserOutlined,
} from '@ant-design/icons';
import { Card, Select, Input, Button, Avatar, Space, Image } from 'antd';
import { theme } from '../../style/theme';
import styled from 'styled-components';
import PostCotent from './post-content/post-cotent';

function Wrapper({ contents }) {
  const Wrapper = styled(Card)`
    max-width: 652px;
    border-color: ${theme.colorLine2};
  `;

  const actionTab = () => {
    return [
      <Space>
        <SmileOutlined
          key="like"
          style={{ fontSize: `${theme.fontSizeIcon}` }}
        />
        좋아요
      </Space>,
      <Space>
        <MessageOutlined
          key="comment"
          style={{ fontSize: `${theme.fontSizeIcon}` }}
        />
        댓글
      </Space>,
      <Space>
        <PaperClipOutlined
          key="shere"
          style={{ fontSize: `${theme.fontSizeIcon}` }}
        />
        공유하기
      </Space>,
    ];
  };

  const createPost = (contents) => {
    return contents.map((content) => (
      <Wrapper
        bodyStyle={{
          paddingLeft: '4px',
          paddingRight: '4px',
          paddingBottom: '8px',
        }}
        actions={actionTab()}
        key={content.id}
      >
        <PostCotent
          content={content.content}
          author={content.author}
          date={content.date}
          comment={content.comment}
          src={content.src}
          like={content.like}
          key={content.id}
        />
      </Wrapper>
    ));
  };

  return (
    <Space direction="vertical" size="small">
      {createPost(contents)}
    </Space>
  );
}

export default Wrapper;
