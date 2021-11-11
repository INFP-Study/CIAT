import React from 'react';
import { Space, Image } from 'antd';
import PostTop from './post-top';
import PostBottom from './post-bottom';

function PostCotent({ content, author, date, comment, src, like }) {
  return (
    <Space direction="vertical" size="small" style={{ width: '100%' }}>
      <PostTop author={author} date={date} />
      <div
        style={{
          marginLeft: 76,
          marginRight: 76,
        }}
      >
        {content}
      </div>
      {src.length !== 0 && (
        <Image.PreviewGroup>
          {src.length === 1 ? (
            <Image width={642} height={642} src={src} />
          ) : (
            src.map((src, i) => (
              <Space size={2} wrap key={i}>
                <Image width={320} height={320} src={src} />
              </Space>
            ))
          )}
        </Image.PreviewGroup>
      )}
      <PostBottom like={like} comment={comment} />
    </Space>
  );
}

export default PostCotent;
