import {
  MessageOutlined,
  PaperClipOutlined,
  SmileOutlined,
  UserOutlined,
} from '@ant-design/icons';
import { Card, Select, Input, Button, Avatar, Space, Image } from 'antd';
import Meta from 'antd/lib/card/Meta';
import React from 'react';
import styled from 'styled-components';
import SiteLayout from '../../components/common/layout';
import { POST_SUBMIT } from '../../constants';
import { theme } from '../../style/theme';

const { Option } = Select;
const { TextArea } = Input;

function Feed(props) {
  const { match } = props;

  const Wrapper = styled.div`
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  `;

  const children = [];
  for (let i = 10; i < 36; i++) {
    children.push(
      <Option key={i.toString(36) + i}>{i.toString(36) + i}</Option>
    );
  }

  const Post = styled(Card)`
    max-width: 652;
    border-color: ${theme.colorLine2};
  `;

  function handleChange(value) {
    console.log(`selected ${value}`);
  }
  return (
    <SiteLayout>
      <Wrapper>
        <Space direction="vertical" size="middle">
          {/*post_write*/}
          <Card style={{ width: 652, borderColor: `${theme.colorLine2}` }}>
            <Space direction="vertical" size="middle" style={{ width: '100%' }}>
              <Meta
                avatar={
                  <Avatar
                    icon={<UserOutlined />}
                    style={{ backgroundColor: `${theme.colorPrimary}` }}
                    size={theme.fontSizeUserIcon}
                  />
                }
                title="홍길동"
                description="08월 20일"
              />
              <Select
                mode="showSearch"
                style={{ width: 210 }}
                placeholder="주제를 선택해 주세요."
                onChange={handleChange}
              >
                {children}
              </Select>
              <TextArea rows={3} autoSize={false} allowClear={true} />
              <Button type="primary" style={{ float: 'right' }}>
                {POST_SUBMIT}
              </Button>
            </Space>
          </Card>

          {/*post*/}
          <Post
            bodyStyle={{
              paddingLeft: '4px',
              paddingRight: '4px',
              paddingBottom: '8px',
            }}
            actions={[
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
            ]}
          >
            <Space direction="vertical" size="small" style={{ width: '100%' }}>
              <Meta
                avatar={
                  <Avatar
                    icon={<UserOutlined />}
                    style={{ backgroundColor: `${theme.colorPrimary}` }}
                    size={theme.fontSizeUserIcon}
                  />
                }
                title="홍길동"
                description="08월 20일"
                style={{ paddingLeft: '16px', paddingRight: '16px' }}
              />
              <Image.PreviewGroup>
                <div
                  style={{ display: 'flex', justifyContent: 'space-between' }}
                >
                  <Image
                    width={320}
                    height={320}
                    src="https://images.unsplash.com/photo-1487009805257-5ed2eb9f10a3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2074&q=80"
                  />
                  <Image
                    width={320}
                    height={320}
                    src="https://images.unsplash.com/photo-1610839563044-8996a168a961?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
                  />
                </div>
              </Image.PreviewGroup>
              <div
                style={{
                  marginLeft: 16,
                  marginRight: 16,
                  display: 'flex',
                  justifyContent: 'space-between',
                }}
              >
                <div>
                  <Space size="middle">
                    <SmileOutlined
                      style={{ fontSize: `${theme.fontSizeIcon}` }}
                    />
                    15개
                  </Space>
                </div>
                <div>댓글 20개</div>
              </div>
            </Space>
          </Post>
        </Space>
      </Wrapper>
    </SiteLayout>
  );
}

export default Feed;
