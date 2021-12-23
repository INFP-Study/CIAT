import React, { useState } from 'react';
import {
  MessageOutlined,
  PaperClipOutlined,
  SmileOutlined,
} from '@ant-design/icons';
import { notification, Card, Space, message } from 'antd';
import { theme } from '../../style/theme';
import styled from 'styled-components';
import FeedContent from './feed-card/feed-card-content';
import useCopyClipBoard from '../../hooks/useCopyClipBoard';
import { Link } from 'react-router-dom';
import { FEED_DETAIL_URL, FEED_ROUTE, FEED_URL } from '../../constants/urls';

const CardAntd = styled(Card)`
  max-width: 652px;
  border-color: ${theme.colorLine2};
`;

function Wrapper({ contents }) {
  const [isCopy, onCopy] = useCopyClipBoard();
  const [isLike, setIsLike] = useState();

  const onShare = (id) => {
    onCopy(window.location.hostname + FEED_DETAIL_URL + '/' + id);
    notification.success({
      message: '스토리 링크가 복사되었어요✨',
      placement: 'bottomRight',
      duration: 1,
    });
  };

  const onLike = () => {
    setIsLike(!isLike);
    // message.warning({
    //   content: '좋아요 기능 준비 중 입니다.',
    //   style: {
    //     marginTop: '10vh',
    //   },
    // });
  };
  const actionTab = (id) => {
    return [
      <Space onClick={() => onLike()}>
        <SmileOutlined
          key="like"
          style={{
            fontSize: `${theme.fontSizeIcon}`,
          }}
        />
        좋아요
      </Space>,
      <Link to={`${FEED_DETAIL_URL}/${id}`}>
        <Space>
          <MessageOutlined
            key="comment"
            style={{ fontSize: `${theme.fontSizeIcon}` }}
          />
          댓글
        </Space>
      </Link>,
      <Space onClick={() => onShare(id)}>
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
      <CardAntd
        bodyStyle={{
          paddingLeft: '4px',
          paddingRight: '4px',
          paddingBottom: '8px',
        }}
        actions={actionTab(content.id)}
        key={content.id}
      >
        <FeedContent
          id={content.id}
          content={content.content}
          author={content.author}
          date={content.date}
          comment={content.comment}
          src={content.src}
          like={content.like}
          key={content.id}
          isLike={isLike}
        />
      </CardAntd>
    ));
  };

  return (
    <Space direction="vertical" size={13}>
      {contents.length !== 0 ? (
        createPost(contents)
      ) : (
        <CardAntd>게시글이 없습니다.</CardAntd>
      )}
    </Space>
  );
}

export default Wrapper;
