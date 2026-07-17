import React from 'react';

class Post {
  constructor(id, title, body) { this.id = id; this.title = title; this.body = body; }
}

export class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = { posts: [], error: null };
  }
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(res => res.json())
      .then(data => this.setState({ posts: data.slice(0, 5).map(p => new Post(p.id, p.title, p.body)) }))
      .catch(err => this.setState({ error: err }));
  }
  componentDidMount() { this.loadPosts(); }
  componentDidCatch(error, info) { alert(error); }
  render() {
    if (this.state.error) return <div>Error loading posts.</div>;
    return (
      <div>
        <h2>Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id}><h4>{post.title}</h4><p>{post.body}</p></div>
        ))}
      </div>
    );
  }
}